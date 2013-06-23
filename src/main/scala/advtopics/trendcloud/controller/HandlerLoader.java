package advtopics.trendcloud.controller;

import java.util.HashMap;
import java.util.Set;
import org.reflections.Reflections;

/**
 * This class performs the dynamic mapping of base url to corresponding
 * RequestHandler class by reading the necessary Handler annotation.
 * 
 * @author Fabi
 * 
 */
public final class HandlerLoader {

	/**
	 * Perform the mapping
	 * 
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> find() {

		// Getting every class annotated with Handler
		HashMap<String, Object> map = new HashMap<String, Object>();
		Reflections ref = new Reflections("advtopics.trendcloud.requesthandler");
		Set<Class<?>> handlers = ref.getTypesAnnotatedWith(advtopics.trendcloud.controller.Handler.class);

		// Loop through classes and get url property of every Handler
		for (Class<?> handler : handlers) {
			try {
				Object obj = handler.newInstance();
				Handler anno = obj.getClass().getAnnotation(Handler.class);
				map.put(anno.url(), obj);
			} catch (InstantiationException e) {
				return map;
			} catch (IllegalAccessException e) {
				return map;
			}
		}
		return map;
	}

}
