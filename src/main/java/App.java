import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Member;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
public class App {

    public static void main(String[] args){
        staticFileLocation("/public");

        get("/member/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "member/member-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: new member form
        post("/member/:idTeam/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String email = request.queryParams("email");
            String education = request.queryParams("education");
            Member member = new Member(name, email, education);
            int idTeam = Integer.parseInt(request.params("idTeam"));
            Team team = Team.findById(idTeam);
            team.getMembers().add(member);
            return new ModelAndView(model, "team/index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
