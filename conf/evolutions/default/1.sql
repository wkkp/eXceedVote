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

INSERT INTO `exceedvote`.`usertype` (`tid`, `user_type`) VALUES (1, 1);
INSERT INTO `exceedvote`.`user` (`uid`, `type_id`, `username`, `password`, `ballotqnty`) VALUES (1, 9, 'admin', 'admin', 100);

INSERT INTO `exceedvote`.`project` (`pid`, `name`) VALUES (1, '\\(>w<!!)/ 1 ~');
INSERT INTO `exceedvote`.`project` (`pid`, `name`) VALUES (2, '\\(OwO!!)/ 2 ~');
INSERT INTO `exceedvote`.`project` (`pid`, `name`) VALUES (3, '\\(TwT!!)/ 3 ~');
INSERT INTO `exceedvote`.`project` (`pid`, `name`) VALUES (4, '\\(-w-!!)/ 4 ~');

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table ballot;

drop table criteria;

drop table project;

drop table user;

drop table usertype;

drop table votetype;

SET FOREIGN_KEY_CHECKS=1;

