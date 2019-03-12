package com.zlb.springboot_jpa.service.impl;

import com.csvreader.CsvWriter;
import com.zlb.springboot_jpa.dao.PersonRepository;
import com.zlb.springboot_jpa.entity.Person;
import com.zlb.springboot_jpa.service.PersonService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String msg) {
        rabbitTemplate.convertAndSend("hello",msg+new Date());
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void getCvs(HttpServletResponse response) {

        List<Person> list = personRepository.findAll();

        String[] header = new String[]{"姓名", "地址", "年龄"};
        ServletOutputStream out = null;
        CsvWriter csvWriter = null;
        Integer sum = 0;
        try {
            out = response.getOutputStream();
            csvWriter = new CsvWriter(out, ',', Charset.forName("UTF-8"));
            csvWriter.writeRecord(header);
            for (Person p : list) {
                csvWriter.write(withString(p.getName()));
                csvWriter.write(withString(p.getAddress()));
                Integer age = p.getAge();
                csvWriter.write(withString(p.getAge()));
                sum += age;
                csvWriter.endRecord();
            }
            csvWriter.write(" 汇 总: ");
            csvWriter.write("");
            csvWriter.write(withString(sum));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            csvWriter.close();
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 属性转环为String类型.
     *
     * @param obj
     * @return String
     */
    private String withString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (String.class.isInstance(obj)) {
            return (String) obj;
        }
        if (Date.class.isInstance(obj)) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format((Date) obj);
        }
        return obj + "";
    }


    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findPerson(Long id) {
        return personRepository.findPersonById(id);
    }


    @Override
    public List<Person> findPerson() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByAddress(String address) {
        return personRepository.findPersonByAddress(address);
    }

    @Override
    public Person findPersonByNameAndAddress(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    @Override
    public Person withNameAndAddress(String name, String address) {
        return personRepository.withNameAndAddressQuery(name, "%" + address + "%");
    }

    @Override
    public Person withNameAndAddressQuery(String name, String address) {
        return personRepository.withNameAndAddressQuery2(name, address);
    }

    /**
     * 格式
     * 升序/降序,"属性名称'
     *
     * @return
     */
    @Override
    public List<Person> sort() {
        return personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
    }

    @Override
    public Page<Person> page() {
        return personRepository.findAll(new PageRequest(1, 2));
    }
}
