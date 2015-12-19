import java.util._
import java.io.File
import java.io.IOException
import java.util.ArrayList

object DirImages{

  def getAllImages(directory: File): ArrayList[String] = {
    val pathList = new ArrayList[String](256)
    val f = directory.listFiles()
    for (file <- f ){
      if (file != null && file.getName.toLowerCase().endsWith(".png")) {
        pathList.add(file.getCanonicalPath)
        pathList.add(file.getCanonicalPath)

      }
    }
    Collections.shuffle(pathList)

    if (pathList.size > 0) {
      pathList
    } else {
      null
    }
  }
}

