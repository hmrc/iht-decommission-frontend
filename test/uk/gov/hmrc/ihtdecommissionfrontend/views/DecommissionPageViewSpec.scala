/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ihtdecommissionfrontend.views

import org.jsoup.Jsoup
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike
import play.api.Application
import play.api.inject.guice.{GuiceApplicationBuilder, GuiceableModule}
import play.api.mvc.MessagesControllerComponents
import play.api.test.FakeRequest
import uk.gov.hmrc.ihtdecommissionfrontend.views.html.DecommissionPage

class DecommissionPageViewSpec extends AnyWordSpecLike with Matchers {

  lazy val fakeApplication: Application = new GuiceApplicationBuilder().bindings(bindModules:_*).build()
  def bindModules: Seq[GuiceableModule] = Seq()
  lazy val decommissionPageView = fakeApplication.injector.instanceOf[DecommissionPage]

  lazy implicit val fakeRequest = FakeRequest()
  implicit lazy val mockMessage = fakeApplication.injector.instanceOf[MessagesControllerComponents].messagesApi.preferred(fakeRequest)

  lazy val view = decommissionPageView()(fakeRequest,mockMessage)
  lazy val document = Jsoup.parse(view.body)

  "Decommission page view" should {

    "have a title of 'Sorry, the service is unavailable'" in {
      document.title shouldBe "Sorry, the service is unavailable"
    }

    "have a body the correct body text" in {
      document.select("#main-content > div > div > p:nth-child(2)").text shouldBe "The Inheritance Tax online service has now closed."
    }

    "have a link with the correct text" in {
      document.select("#main-content > div > div > p:nth-child(3) > a").text shouldBe "Find out how to value an estate for Inheritance Tax and report its value."
      document.select("#main-content > div > div > p:nth-child(3) > a").attr("href") shouldBe "https://www.gov.uk/valuing-estate-of-someone-who-died"
    }
  }

}
