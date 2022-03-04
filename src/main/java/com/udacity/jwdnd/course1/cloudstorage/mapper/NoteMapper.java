package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    List<Note> getNotesFromThisUser(Integer integer);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid" +
            "VALUES (#{noteTitle}, #{noteDescription}, #{userId}")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    Integer insert(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void deleteNote(Integer noteId);

    @Update("UPDATE NOTES SET notetile = #{noteTitle}, notedescription = #{noteDescription}, userid = #{userId}" +
            "WHERE noteid = #{noteId}")
    Integer updateNote(Note note);
}
