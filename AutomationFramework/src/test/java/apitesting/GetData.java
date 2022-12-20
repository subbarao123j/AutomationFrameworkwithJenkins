/*
 * package apitesting;
 * 
 * import org.testng.Assert; import org.testng.annotations.Test;
 * 
 * import io.restassured.RestAssured; import io.restassured.response.Response;
 * import io.restassured.response.ResponseBodyData;
 * 
 * public class GetData {
 * 
 * @Test public void testStatusCode() {
 * 
 * 
 * 
 * Response code=RestAssured .given()
 * .get("https://reqres.in/api/users?page=2"); testStatusCode();
 * System.out.println(code);
 * 
 * Assert.assertEquals(code, 200);
 * 
 * 
 * 
 * }
 * 
 * 
 * @Test public void testContent() {
 * 
 * 
 * Response data = RestAssured //int code=RestAssured .given()
 * .get("https://reqres.in/api/users?page=2"); .getBody().asString();
 * 
 * Assert.assertTrue(((String) data).contains("Michael"));
 * System.out.println(data);
 * 
 * 
 * 
 * 
 * 
 * }
 * 
 * 
 * private ResponseBodyData getBody() { // TODO Auto-generated method stub
 * return null; }
 * 
 * }
 */
