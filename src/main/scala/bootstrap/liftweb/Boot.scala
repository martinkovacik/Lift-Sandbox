package bootstrap.liftweb

import net.liftweb._
import net.liftweb.http.LiftSession
import http.{LiftRules, NotFoundAsTemplate, ParsePath}
import sitemap.{SiteMap, Menu, Loc}
import util.{ NamedPF }
import net.liftweb.sitemap.Loc._
import net.liftweb.http.Bootable
import net.liftweb.http.Req
import net.liftweb.http.Html5Properties


class Boot extends Bootable{
  override def boot {
    // where to search snippet
    LiftRules.addToPackages("sk.clickspace.liftsandbox")

    // build sitemap
    val entries = List(Menu("Example") / "example")
    	
    LiftRules.uriNotFound.prepend(NamedPF("404handler"){
      case (req,failure) => NotFoundAsTemplate(
        ParsePath(List("exceptions","404"),"html",false,false))
    })
    
    LiftRules.setSiteMap(SiteMap(entries:_*))
    
    // set character encoding
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))
    
    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent)) 
    
  }
}
