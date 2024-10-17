package lp;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class TaskTest {
    @Test
    void createTask() {
        given()
                .body("{\"title\": \"Task 1\", \"description\": \"Description of Task 1\", \"done\": false}")
                .header("Content-Type", "application/json")
                .when()
                .post("/tasks")
                .then()
                .statusCode(201)
                .body("title", is("Task 1"))
                .body("description", is("Description of Task 1"))
                .body("done", is(false));
    }

    void listTasks() {
        given()
                .when().get("/tasks")
                .then()
                .statusCode(200)
                .body("$.size()", is(1));
    }

    void getTaskById() {
        given()
                .when().get("/tasks/1")
                .then()
                .statusCode(200)
                .body("title", is("Task 1"))
                .body("description", is("Description of Task 1"))
                .body("done", is(false));
    }

    void updateTask() {
        given()
                .body("{\"title\": \"Task 1\", \"description\": \"Description of Task 1\", \"done\": true}")
                .header("Content-Type", "application/json")
                .when()
                .put("/tasks/1")
                .then()
                .statusCode(200)
                .body("title", is("Task 1"))
                .body("description", is("Description of Task 1"))
                .body("done", is(true));
    }

    void deleteTask() {
        given()
                .when().delete("/tasks/1")
                .then()
                .statusCode(204);
    }

}