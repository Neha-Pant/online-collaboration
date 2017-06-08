package org.socialnetworking.dao;

import java.util.List;
import org.socialnetworking.model.*;

public interface IEventDAO {

		boolean saveOrUpdate(Event event);

		boolean delete(Event event);

		Event get(int id);

		List<Event> list();

		boolean addEvent(Event e);

	}
