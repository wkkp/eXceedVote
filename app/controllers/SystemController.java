package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.*;
import models.*;

/**
 * Manage projects related operations.
 */
@Security.Authenticated(Secured.class)
public class SystemController extends Controller {

	static Form<ExceedTimer> exceedTimerForm = form(ExceedTimer.class);

	public static Result system() {
		return ok(views.html.adminSystem.render(User.findByUsername(request().username())
											  , ExceedTimer.getTimer()
											  , exceedTimerForm)
		);
	}

	public static Result saveNewTimer() {
		Form<ExceedTimer> etform = exceedTimerForm.bindFromRequest();
		ExceedTimer.saveTimer(etform.get());

		System.out.println(etform.get().year); 

		return ok(views.html.adminSystem.render(User.findByUsername(request().username())
											  , ExceedTimer.getTimer()
											  , exceedTimerForm)
		);
	}
}