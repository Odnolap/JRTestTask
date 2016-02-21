package ru.odnolap.JRTestTask.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.odnolap.JRTestTask.domain.Todo;

import java.util.List;

@Repository
@Transactional
public class TodoRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Todo> listAll() {
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from Todo")
                .list();
    }

    public List<Todo> listFilteredCompleted() {
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from Todo t where t.stat = ?")
                .setString(0, "Completed")
                .list();
    }

    public List<Todo> listFilteredUncompleted() {
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from Todo t where t.stat = ?")
                .setString(0, "Uncompleted")
                .list();
    }

    public void removeTodo(Integer id) {
        Todo todo = (Todo) this.sessionFactory.getCurrentSession().load(Todo.class, id);
        if (todo != null) {
            this.sessionFactory.getCurrentSession().delete(todo);
        }
    }

    public void completeTodo(Integer id) {
        Todo todo = (Todo) this.sessionFactory.getCurrentSession().load(Todo.class, id);
        if (todo != null) {
            todo.setStat("Completed");
        }
    }

    public void addTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().save(todo);
    }

    public void editTodo(Todo todo) {
        this.sessionFactory.getCurrentSession().merge(todo);
    }

    public Todo getTodoById(Integer id) {
        Todo todo = null;
        try {
            todo = (Todo) this.sessionFactory
                    .getCurrentSession()
                    .createQuery("from Todo t where t.id = ?")
                    .setInteger(0, id)
                    .list()
                    .get(0);
        } catch (Exception ignored) {}

        return todo;
    }

}
