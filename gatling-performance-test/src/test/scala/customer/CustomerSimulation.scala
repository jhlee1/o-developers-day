import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class CustomerSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")

  val scn = scenario("Create and Delete Customer") // A scenario is a chain of requests and pauses
    .exec(http("customer_list")
      .get("/customers"))
    .pause(1)
    .exec(http("create customer")
      .post("/customer"))
    .pause(1)
    .exec(http("r")
      .post("/customer")
      .formParam("""name""", """user1""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
      .formParam("""email""", """user1@example.com"""))
    .pause(1)

  setUp(scn.inject(atOnceUsers(10)).protocols(httpProtocol))
}