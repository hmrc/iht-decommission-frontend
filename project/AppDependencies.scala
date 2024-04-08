import sbt._

object AppDependencies {

  private val bootstrapVersion = "8.4.0"

  val compile = Seq(
    "uk.gov.hmrc"     %% "bootstrap-frontend-play-30" % bootstrapVersion,
    "uk.gov.hmrc"     %% "play-frontend-hmrc-play-30" % "9.5.0"
  )

  val test = Seq(
    "uk.gov.hmrc"  %% "bootstrap-test-play-30"  % bootstrapVersion    % "test, it",
    "org.jsoup"    %  "jsoup"                   % "1.17.2"            % Test,
  )
}
