package com.feiniaojin.gracefuresponse.example.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feiniaojin.gracefulresponse.api.ValidationStatusCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;


@Data
public class MethodDTO {

    @NotNull(message = "uid is null !")
    @Length(min = 6, max = 12)
    @ValidationStatusCode(code = "520")
    private String uid;

    @NotNull(message = "innerDTO is null")
//    @ValidationStatusCode(code = "521")
    @Valid
    private InnerDto innerDto;

    public static void main(String[] args) throws JsonProcessingException {
        String input = "{\n" +
                "    \"uid\": \"123456\",\n" +
                "    \"inner\": {\n" +
                "        \"innerProperty\": null\n" +
                "    }\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();
        MethodDTO methodDTO = mapper.readValue(input, MethodDTO.class);
        System.out.println("");
    }
}
