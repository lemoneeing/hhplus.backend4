package cleanarchitecture.business;

import org.springframework.stereotype.Service;

@Service
public class EnrolleeService {

    final IEnrolleeRepository repository;

    public EnrolleeService(IEnrolleeRepository repo) {
        this.repository = repo;
    }
}
