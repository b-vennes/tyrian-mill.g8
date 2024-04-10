import \$ivy.`com.lihaoyi::mill-contrib-bloop:\$MILL_VERSION`
import \$ivy.`com.goyeau::mill-scalafix::$scalafix_version$`
import com.goyeau.mill.scalafix.ScalafixModule
import mill._
import mill.scalalib._
import mill.scalalib.scalafmt._
import mill.scalajslib._
import mill.scalajslib.api._

object $project_name$ extends RootModule with ScalaJSModule with ScalafmtModule with ScalafixModule {
  def scalaVersion   = "$scala_version$"
  def scalaJSVersion = "$scala_js_version$"

  def ivyDeps = Agg(
    ivy"io.indigoengine::tyrian::$tyrian_version$",
    ivy"io.indigoengine::tyrian-io::$tyrian_version$"
  )

  override def moduleKind = T(mill.scalajslib.api.ModuleKind.CommonJSModule)

  object test extends ScalaJSTests with TestModule.Munit {
    def ivyDeps = Agg(ivy"org.scalameta::munit::$munit_version$")

    def testFramework = "munit.Framework"

    override def moduleKind = T(mill.scalajslib.api.ModuleKind.CommonJSModule)
  }
}
