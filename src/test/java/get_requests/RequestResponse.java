package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    /*
    Sellenium web otomasyonu, rest assured ise api otomasyonu icin kullanilan eklentiler

    1-Manuel API testi icin Postman kullaniyoruz.
    2-API otomasyon testi icin REST Assured kutuphanesini kullaniyoruz.
    3-Otomasyon kodlarinin yazimi icin su adimlari izleriz:
    A-Gereksinimleri anlama
    B-Test senaryosu yazma
    a-Test senaryosu yazmak icin Gherkin language kullaniyoruz.
    -Given: Endpoint, body ...
    -When: get, put, post gibi islemler
    -Then: Assertion, Close ...
    -And: Coklu islemlerin ard arda yapildigi zamanlarda kullanilir.
    C-Otomasyon kodlarini yazarken su adimlari izleriz:
    1-Set the URL
    2-Set the expected data
    3-Send the request and get the response
    4-Do assertion
     */

    public static void main(String[] args) {
    // Get testi nasil yapilir?
    String url="https://petstore.swagger.io/v2/pet/484620167"; //postman'da get id methodumuzdaki url'i aldik
    //Her zaman given ile baslayip ve sonra when ile devam edecegiz
    Response response=given().when().get(url); //given() ile Response'u import ettik
        //given().when().get(url) bize Response classindan Response return eder. url'imiz response icine gelecek
        //response yazdirmak icin sout ile yazdirma yapariz
        System.out.println(response);
        //io.restassured.internal.RestAssuredResponseImpl@15dd5ac2 bu bir hashcode biz bunu istemiyoruz
        response.prettyPrint(); //bu method ile hashcode yerine datayi dogrudan gorebiliriz
      //run edince response body'imiz icinde datamiz geldi. Icinde freddy ve dog olarak guncelledigimiz
      //bilgiler var.

     //Status Code nasil yazdirilir?
        System.out.println("Status Code:" +response.statusCode()); //datamiz response icinde oldugundan onu kullaniriz
     //io.restassured.internal.RestAssuredResponseImpl@15dd5ac2
        //Status Code200

    //Content Type nasil yazdirilir?
        System.out.println("Content Type:" +response.contentType());
    //Content Type:application/json bu bilgi ayrica postman'da Headers bolumunde bulunuyor
        System.out.println("---------------------");

        //Status Line nasil yazdirilir?
        System.out.println("Status Line:" +response.statusLine());
      //Status Line:HTTP/1.1 200 OK   http'nin versiyonunu verdi

      //Header'daki veriler nasil yazdirilir? Header bolumunden Server kismini yazdirmak istersek:
        System.out.println("Header  |  Server: " +response.header("Server"));
       //Header  |  Server: Jetty(9.2.9.v20150224) postman Headers'da Server karsisinda value olan kisim yazildi

    //Headers nasil yazdirilir?
        System.out.println("Headers:" +response.headers());
    //postmanda headers bolumunu key ve valuleri ile birlikte tamamen yazdirdi

     //Time nasil yazdirilir?
        System.out.println("Time:" +response.time());
    }
}
