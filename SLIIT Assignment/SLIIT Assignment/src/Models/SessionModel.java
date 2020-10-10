/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


public class SessionModel {
    private int session_id,no_of_students;
    private WorkingDayManagemenHasDay2 duration;
    private SubjectModel subject_id;
    private TagModel tag_id;
    private Student student_id;
    private int status;
    private BlockModel building_block_bb_id;
    private Lecturer lecturer;

    public SessionModel(int session_id, int no_of_students, WorkingDayManagemenHasDay2 duration, SubjectModel subject_id, TagModel tag_id, Student student_id, int status, BlockModel building_block_bb_id) {
        this.session_id = session_id;
        this.no_of_students = no_of_students;
        this.duration = duration;
        this.subject_id = subject_id;
        this.tag_id = tag_id;
        this.student_id = student_id;
        this.status = status;
        this.building_block_bb_id = building_block_bb_id;
    }

    public SessionModel(int no_of_students, WorkingDayManagemenHasDay2 duration, SubjectModel subject_id, TagModel tag_id, Student student_id, int status, BlockModel building_block_bb_id) {
        this.no_of_students = no_of_students;
        this.duration = duration;
        this.subject_id = subject_id;
        this.tag_id = tag_id;
        this.student_id = student_id;
        this.status = status;
        this.building_block_bb_id = building_block_bb_id;
    }

    public SessionModel(int session_id, int no_of_students, WorkingDayManagemenHasDay2 duration, SubjectModel subject_id, TagModel tag_id, Student student_id, int status, BlockModel building_block_bb_id, Lecturer lecturer) {
        this.session_id = session_id;
        this.no_of_students = no_of_students;
        this.duration = duration;
        this.subject_id = subject_id;
        this.tag_id = tag_id;
        this.student_id = student_id;
        this.status = status;
        this.building_block_bb_id = building_block_bb_id;
        this.lecturer = lecturer;
    }

    public SessionModel(int no_of_students, WorkingDayManagemenHasDay2 duration, SubjectModel subject_id, TagModel tag_id, Student student_id, int status, BlockModel building_block_bb_id, Lecturer lecturer) {
        this.no_of_students = no_of_students;
        this.duration = duration;
        this.subject_id = subject_id;
        this.tag_id = tag_id;
        this.student_id = student_id;
        this.status = status;
        this.building_block_bb_id = building_block_bb_id;
        this.lecturer = lecturer;
    }



    public int getSession_id() {
        return session_id;
    }

    public int getNo_of_students() {
        return no_of_students;
    }

    public WorkingDayManagemenHasDay2 getDuration() {
        return duration;
    }

    public SubjectModel getSubject_id() {
        return subject_id;
    }

    public TagModel getTag_id() {
        return tag_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public int getStatus() {
        return status;
    }

    public BlockModel getBuilding_block_bb_id() {
        return building_block_bb_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public void setNo_of_students(int no_of_students) {
        this.no_of_students = no_of_students;
    }

    public void setDuration(WorkingDayManagemenHasDay2 duration) {
        this.duration = duration;
    }

    public void setSubject_id(SubjectModel subject_id) {
        this.subject_id = subject_id;
    }

    public void setTag_id(TagModel tag_id) {
        this.tag_id = tag_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setBuilding_block_bb_id(BlockModel building_block_bb_id) {
        this.building_block_bb_id = building_block_bb_id;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    
    
}
