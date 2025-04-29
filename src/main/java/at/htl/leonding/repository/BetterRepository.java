package at.htl.leonding.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import java.util.Arrays;
import java.util.List;

public abstract class BetterRepository<T> implements PanacheRepository<T> {
	public static final String ID_FIELD_NAME = "Id";
	private final Class<T> type;
	private String idFieldName = "";

	protected BetterRepository(Class<T> type) {
		this.type = type;
	}

	public T findById(String id) {
		return find(idField(), id).firstResult();
	}

	public String idField() {
		if (idFieldName.isEmpty()) {
			idFieldName = Arrays.stream(type.getDeclaredFields()).filter(s -> s.getName().contains(ID_FIELD_NAME))
					.findFirst().orElseThrow(
							() -> new IllegalStateException(type.getName() + " does not have a valid Id field"))
					.getName();
		}

		return idFieldName;
	}

	public Class<T> getType() {
		return this.type;
	}

	public boolean deleteById(String id) {
		return deleteById(Long.valueOf(id));
	}

	@Override
	public List<T> listAll() {
		return this.listAll(Sort.ascending(idField()));
	}
}