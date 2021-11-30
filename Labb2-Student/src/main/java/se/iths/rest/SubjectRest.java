package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("getall")
    @GET
    public Response getAllSubjects() {
        List<Subject> listOfSubjects = subjectService.getAllSubjects();
        return Response.ok(listOfSubjects).build();
    }

//    @Path("")
//    @GET
//    public Response getEverything() {
//        List<Subject> everything = subjectService.getAllSubjectsStudentsAndTeachers();
//        return Response.ok(everything).build();
//    }

    @Path("{id}")
    @GET
    public Response getSubjectById(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.getSubjectById(id);
        return Response.ok(foundSubject).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) {
        subjectService.deleteSubject(id);
        return Response.ok("Subject with ID: " + id + " has been deleted").type(MediaType.TEXT_PLAIN).build();
    }
}
