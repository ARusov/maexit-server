package net.maexit.controller;

import net.maexit.entity.Course;
import net.maexit.entity.UploadAnswer;
import net.maexit.repository.CourseRepository;
import net.maexit.repository.CourseSectionRepository;
import net.maexit.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by arusov on 14.03.2018.
 */
@CrossOrigin
@RestController
@RequestMapping("/publicapi")
public class CourseController {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private CourseSectionRepository courseSectionRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AmazonClient amazonClient;


    @RequestMapping("/initcourse/{courseId}")
    @ResponseBody
    public Course getCourse(@PathVariable("courseId") String courseId) {
        Course course = courseRepository.findById(courseId).get();
        return course;
    }


    @RequestMapping(value = "/initcourse/create", method = RequestMethod.POST)
    @ResponseBody
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.insert(course);
    }

    @RequestMapping(value = "/initcourse/update", method = RequestMethod.POST)
    @ResponseBody
    public Course updateCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }


    @RequestMapping(value = "/initcourses", method = RequestMethod.GET)
    @ResponseBody
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }


    @RequestMapping(value = "/initcourse/upload/file", method = RequestMethod.POST)
    @ResponseBody
    public UploadAnswer handleFileUpload(@RequestParam("file") MultipartFile file,
                                         RedirectAttributes redirectAttributes) {

        String path = this.amazonClient.uploadFile(file);
        UploadAnswer answer= new UploadAnswer("file",file.getOriginalFilename(),path);

        return answer;
    }

    @RequestMapping(value = "/initcourse/upload/video", method = RequestMethod.POST)
    @ResponseBody
    public UploadAnswer handleVideoUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        String path = this.amazonClient.uploadFile(file);
        UploadAnswer answer= new UploadAnswer("video",file.getOriginalFilename(),path);

        return answer;
    }



}
