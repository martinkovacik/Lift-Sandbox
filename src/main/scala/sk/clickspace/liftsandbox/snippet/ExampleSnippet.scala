package sk.clickspace.liftsandbox.snippet
import net.liftweb.http.SessionVar
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.util.CssSel
import net.liftweb.http.js.JsCmds
import scala.xml.Text
import net.liftweb.http.js.JsCmds.SetHtml

object ExampleSnippet {
  
  private object tableModel extends SessionVar[List[String]](List("1", "2", "3", "4"))
  
  def renderControls() = {
    ".b_link" #> SHtml.a(() => {
      tableModel(tableModel.get.reverse)
      // WHAT TO INSERT HERE INSTEAD OF Noop ???
      JsCmds.Noop
    }, Text("Reverse table"))
  }
  
  def renderTable() = {
    "tr" #> tableModel.get.map {
			model =>
			".b_name *" #> model
		}
  }
  
}
