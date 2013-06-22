package advtopics.trendcloud.controller;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Set;

import org.reflections.Reflections;

public class HandlerLoader {
	
	public HashMap<String, Object> find() {

		  HashMap<String, Object> map = new HashMap<String, Object>();
		  Reflections ref = new Reflections("advtopics.trendcloud.requesthandler");
		  Set<Class<?>> handlers = ref.getTypesAnnotatedWith(advtopics.trendcloud.controller.Handler.class);
		  
		  for (Class<?> handler : handlers) {
			try {
				Object obj = handler.newInstance();
				Handler annos = obj.getClass().getAnnotation(Handler.class);
				map.put(annos.url(), obj);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		  }
		  
		  return map;
	}
	
}
