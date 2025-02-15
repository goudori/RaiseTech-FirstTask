package org.example;

public class Student {

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  private String name;

  private int score;

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", score=" + score +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
