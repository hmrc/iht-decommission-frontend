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

package uk.gov.hmrc.ihtdecommissionfrontend.controllers

import uk.gov.hmrc.ihtdecommissionfrontend.views.html.DecommissionPage
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import javax.inject.{Inject, Singleton}
import scala.concurrent.Future

@Singleton
class IndexController @Inject()(
  mcc: MessagesControllerComponents,
  decommissionView: DecommissionPage)
    extends FrontendController(mcc) {

  val decommissionPage: Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(decommissionView()))
  }

  def matchAll(url: String): Action[AnyContent] = Action.async { implicit request =>
    Future.successful(Ok(decommissionView()))
  }

}
