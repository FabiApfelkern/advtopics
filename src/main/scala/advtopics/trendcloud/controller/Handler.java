package advtopics.trendcloud.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is used to mark RequestHandlers with its
 * responsible URL. 
 * Example: @Handler(url="main"), would map the RequestHandler
 * to the url: www.example.com/main
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Handler {
	public String url();
}
