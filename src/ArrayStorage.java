import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int index = 0;

    void clear() {
        Arrays.fill(storage, null);
        index = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < index; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                storage[i] = r;
                return;
            }
        }
        storage[index++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < index; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < index; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[--index];
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, index);
    }

    int size() {
        return index;
    }
}
