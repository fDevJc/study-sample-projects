package com.jc.swaggerexample.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "스웨거컨트롤러")
@RestController
public class SwaggerController {

    @Operation(summary = "요약", description = "설명")
    @ApiResponse(code = 200, message = "ok")
    @GetMapping("/swagger")
    public ResponseDto swaggerHello() {
        return new ResponseDto();
    }

    public class ResponseDto {
        @ApiModelProperty(value = "아이디", example = "1", required = true)
        private Long id;
        @ApiModelProperty(value = "이름", example = "홍길동")
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
