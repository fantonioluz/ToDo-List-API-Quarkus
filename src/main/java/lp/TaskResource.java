package lp;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;



@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> list() {
        return Task.listAll();
    }

    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") Long id) {
        return Task.findById(id);
    }

    @POST
    @Transactional
    public Response createTask(Task task) {
        task.persist();
        return Response.status(Response.Status.CREATED).entity(task).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Task updateTask(@PathParam("id") Long id, Task updateTask){
        Task task = Task.findById(id);
        if(task == null){
            throw new WebApplicationException("Task with id of " + id + " does not exist.", 404);
        }
        task.title = updateTask.title;
        task.description = updateTask.description;
        task.done = updateTask.done;
        return task;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTask(@PathParam("id") Long id){
        boolean deleted = Task.deleteById(id);
        if(deleted){
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            throw new WebApplicationException("Task with id of " + id + " does not exist.", 404);
        }
    }

}
