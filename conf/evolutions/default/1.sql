# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ballot (
  bid                       bigint auto_increment not null,
  user_id                   bigint,
  project_id                bigint,
  criteria_id               bigint,
  score                     integer,
  constraint pk_ballot primary key (bid))
;

create table criteria (
  cid                       bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_criteria primary key (cid))
;

create table project (
  pid                       bigint auto_increment not null,
  name                      varchar(255),
  description               TEXT,
  constraint pk_project primary key (pid))
;

create table user (
  uid                       bigint auto_increment not null,
  type_id                   integer,
  username                  varchar(255),
  password                  varchar(255),
  ballotqnty                integer,
  constraint pk_user primary key (uid))
;

create table usertype (
  tid                       bigint auto_increment not null,
  user_type                 integer,
  ballot_qnty               integer,
  constraint pk_usertype primary key (tid))
;

create table votetype (
  vid                       bigint auto_increment not null,
  vote_type                 integer,
  vote_criterion            integer,
  constraint pk_votetype primary key (vid))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ballot;

drop table criteria;

drop table project;

drop table user;

drop table usertype;

drop table votetype;

SET FOREIGN_KEY_CHECKS=1;

