package advtopics.view

import org.apache.velocity.VelocityContext
import javax.servlet.http.HttpServletResponse
import java.io.PrintWriter
import advtopics.trendcloud.controller.interfaces.Response
import java.io.InputStreamReader
import scala.collection.mutable.HashMap
import java.io.StringWriter
import org.apache.velocity.app.Velocity
import org.apache.velocity.tools.generic.EscapeTool

/**
 * The ReponsereRenderer takes a ResponseObject and renders the template with the
 * set parameters and sends it via HttpServletResponse Object to the user
 */
class ResponseRenderer(res: HttpServletResponse) {

  val context = new VelocityContext
  val writer = new StringWriter

  def send(response: Response) = {
    val out: PrintWriter = res.getWriter();
    val reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(response.getTemplate))
    context.put("esc", new EscapeTool());
    response.getParameters.foreach { p =>
      context.put(p._1, p._2)
    }
    Velocity.evaluate(context, writer, "", reader)

    out.println(writer.toString)
    out.close

  }
}