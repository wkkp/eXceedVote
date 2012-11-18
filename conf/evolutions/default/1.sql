# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ballot (
  id                        bigint auto_increment not null,
  user_id                   bigint,
  project_id                bigint,
  criteria_id               bigint,
  score                     integer,
  constraint pk_ballot primary key (id))
;

create table criteria (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_criteria primary key (id))
;

create table project (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  description               varchar(255),
  constraint pk_project primary key (id))
;

create table user (
  id                        bigint auto_increment not null,
  type_id                   integer,
  username                  varchar(255),
  password                  varchar(255),
  ballotqnty                integer,
  constraint pk_user primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ballot;

drop table criteria;

drop table project;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

