//Jeffrey Phung
import scala.swing._
import scala.swing.event._
import javax.swing.Timer
import javax.swing.ImageIcon
import java.awt.Dimension
import java.awt.Color
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File

class Board extends MainFrame {
	val ani: String = "Animals";
	val sports: String = "Sports";
	val plants: String = "Plants";
	val fish: String = "Fishes";
	val candy: String = "Candies";
	val color: String = "Colors";

	var dir: File = new File("."); //class var init to arbitrary value
	var matchedCount = 0;
	val winCount = 5;

	title = "Matching Game";

	//category buttons in a tuple
	val (button1, button2, button3, button4, button5, button6) =
		(new Button(ani),
		 new Button(sports),
		 new Button(plants),
		 new Button(fish),
		 new Button(candy),
		 new Button(color));

	//(category screen) added to an array to iterate through
	val buttons = Array(button1, button2, button3, button4, button5, button6);
	val buttonSize = new Dimension(180, 120);

	//category screen
	contents = new FlowPanel() {
		for(button <- buttons){
			button.preferredSize = buttonSize;
			contents += button;
		}

	} // end category screen

	//reactor to category screen
	for(button <- buttons)
		listenTo(button);
	reactions+={
		case ButtonClicked(button)=> 
			if (button == button1){
				showBoard(ani);
			}
			else if(button == button2){
				showBoard(sports);
			}
			else if(button == button3){
				showBoard(plants);
			}
			else if(button == button4){
				showBoard(fish);
			}
			else if(button == button5){
				showBoard(candy);
			}
			else if(button == button6){
				showBoard(color);
			}
	}

	/**************************************
	 *
	 * Start of category implementation 
	 * ************************************/

	def checkCards(panel1: String, panel2: String) : Boolean = {
		if(panel1.equals(panel2)){
			return true;
		} 
		else{
			return false;
		}
	}

	//populates the board from stock images
	def showBoard(typeIs: String){

		val aniImg = DirImages;
		var currentMode : Int = 0; // 0 = init, 1 = check
		var currentCard: String = "";


		if (typeIs == ani){
			dir = new File(ani + "/");
		}
		else if (typeIs == sports){
			dir = new File(sports + "/");
		}
		else if(typeIs == plants){
			dir = new File(plants + "/");
		}
		else if(typeIs == fish){
			dir = new File(fish + "/");
		}
		else if(typeIs == candy){
			dir = new File(candy +"/");
		}
		else if(typeIs == color){
			dir = new File(color +"/");
		}

		val list = aniImg.getAllImages(dir);
		val iter = list.iterator;
		contents = new FlowPanel(){

			changeSize();


			//Sets up matching cards
			while(iter.hasNext()){
				val path: String = iter.next();
				val indexOfDot: Int = path.indexOf(".png");
				val indexOfSlash: Int = path.lastIndexOf('/');
				val names: String = path.substring(indexOfSlash + 1, indexOfDot);
				contents += new Button(){
					focusPainted = false;
					background = Color.DARK_GRAY;
					listenTo(this);
					reactions+={
						case ButtonClicked(cards)=>
							//initial state of cards
							if (currentMode == 0){
								currentMode = 1;    //switch modes on next card click
								currentCard = names;  //set card to check against
								deafTo(this);
								showFace();
							}
						//checking state of cards
							else if (currentMode == 1){
								//matched cards
								if(checkCards(currentCard, names)){
									showFace();
									currentMode = 0;
									currentCard = "";
									deafTo(this);
									matchedCount += 1;
									if(matchedCount == winCount){win()}

								}
								//else non match, still checking mode
								else{
									showFace();
									var timer: Timer = null;
									val action = new ActionListener(){

										override def actionPerformed(event : ActionEvent){
											icon = null;
											text = "";
											background = Color.DARK_GRAY;
											timer.stop();
										}
									};
									timer = new Timer (1000, action);
									timer.start();
								}
							}

					}

					//nested function show face
					def showFace()={
						text = names;
						horizontalTextPosition = Alignment.Center;
						verticalTextPosition = Alignment.Bottom;
						background = Color.WHITE;
						val icons = new ImageIcon(path);
						val newIc = icons.getImage();
						val newIcons = newIc.getScaledInstance(100, 75, 
								java.awt.Image.SCALE_SMOOTH);
						icon = new ImageIcon(newIcons);
					}
					preferredSize = new Dimension(185,185)  //size of button

				}
			}

		}//end flowpanel
		def win(){
			if(matchedCount == winCount){
				contents = new BoxPanel(Orientation.Vertical){
					contents += new Label("YOU WIN");
					contents += new Button("RETRY?"){
						listenTo(this);
						reactions += {
							case ButtonClicked(retry) =>
								println("Launching new game...");
							dispose;
							newGameCall();
						}
					}
				}
			}
		}
	}


	def newGameCall(){
		dispose;
		new Board().resizable = false;
	}
	def changeSize(){
		preferredSize = new Dimension(955,385);
		pack();
	}
	
	preferredSize = new Dimension(570, 260);
	resizable = false;
	visible = true;
	pack();
	println(this.toString);

}//end Board class

object Board {
	def main(args: Array[String]) {
		val ui = new Board;
		ui.visible = true;
	}
	sys.exit(1);
} //end Board object


