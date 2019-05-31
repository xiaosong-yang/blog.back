package top.yyf256.blog.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"top.yyf256"})
@ServletComponentScan({"top.yyf256.blog.web.restController",
						"top.yyf256.blog.web.pageController",
						"top.yyf256.blog.web.listener"})
@MapperScan(basePackages={"top.yyf256.blog.dao",
		                  "top.yyf256.blog.repository"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
