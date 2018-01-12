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

        //----------INIT MEMBER-----------------------------------------

        get("/member/:id/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idTeam = Integer.parseInt(request.params("id"));
            model.put("idTeam",idTeam);
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
            team.setNumberOfMembers(team.getMembers().size());
            ArrayList<Team> teams = Team.getTeams();
            model.put("teams", teams);
            return new ModelAndView(model, "team/index.hbs");
        }, new HandlebarsTemplateEngine());

        //------------INIT TEAM---------------------------------------------

        get("/team/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team/team-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: new team form
        post("/team/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            Team team = new Team(name, description);
            ArrayList<Team> teams = Team.getTeams();
            model.put("teams", teams);
            return new ModelAndView(model, "team/index.hbs");
        }, new HandlebarsTemplateEngine());
        get("/team/view/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idTeam = Integer.parseInt(request.params("id"));
            Team team = Team.findById(idTeam);
            model.put("team", team);
            return new ModelAndView(model, "team/team-detail.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
