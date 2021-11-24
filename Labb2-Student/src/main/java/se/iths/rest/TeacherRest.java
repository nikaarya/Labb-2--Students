package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("createteacher")
    @POST
    public Response createTeacher(Teacher teacher) {
        teacherService.createNewTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("getallteachers")
    @GET
    public Response getAllTeachers() {
        List<Teacher> listOfTeachers = teacherService.getAllTeachers();
        return Response.ok(listOfTeachers).build();
    }

    @Path("{id}")
    @GET
    public Response getTeacherById(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.getTeacherById(id);
        return Response.ok(foundTeacher).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        teacherService.deleteTeacher(id);
        return Response.ok("Teacher with ID: " + id + " has been deleted").build();
    }

}
