import java.io.InputStream

fun getResourceAsText(path: String): String {
    // Load file from resources
   val resource = object {}.javaClass.getResource(path) // adjust the path accordingly
    
   if (resource != null) {
       // Open the file as an InputStream
       val inputStream: InputStream = resource.openStream()
       
       // Optionally, read the content (as an example)
       val content = inputStream.bufferedReader().use { it.readText() }

       return content
   } 
   
   println("File not found!")
   return ""
}