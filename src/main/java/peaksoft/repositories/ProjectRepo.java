package peaksoft.repositories;

import peaksoft.models.Project;

import java.util.List;

/**
 * ~ @created 06/02/2023
 * ~ @project_name spring_core_session_relationship
 * ~ @author kurbanov
 **/
public interface ProjectRepo {
    void save(Project project);

    void saveAll(List<Project> projects);

    List<Project> findAll();

    Project findById(Long id);

    void deleteById(Long id);

    void deleteAll();

    Project update(Long id, Project project);


}
