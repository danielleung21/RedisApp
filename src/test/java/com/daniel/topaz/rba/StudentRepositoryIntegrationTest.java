package com.daniel.topaz.rba;

import com.daniel.topaz.rba.dm.Student;
import com.daniel.topaz.rba.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class StudentRepositoryIntegrationTest {

    @Autowired
    private StudentRepository repo;

    @Test
    public void shouldSaveStudent_toRedis() {
        //given
        Student student = new Student("Eng2015001","John Doe", Student.Gender.MALE,1);

        //when
        Student savedStudent = repo.save(student);

        //then
        assertNotNull(savedStudent);
    }

    @Test
    public void keepRunning() throws InterruptedException {
        while(true) {
            Thread.sleep(10000L);
        }
    }

}
