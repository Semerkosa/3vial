use server_landing_page_db;
insert ignore into data (id, email, timestamp)
values ('2947c292-fb1f-4157-817c-0f533c14a278', 'test1@abv.bg', '2021-10-21T05:47:08.644'),
       ('8fc49611-18c8-4e9a-b666-bc9015a0e71b', 'test2@abv.bg', '2021-10-21T05:47:08.644'),
       ('b5c29689-f5a1-44c5-bad2-09afdd9a51ef', 'test3@abv.bg', '2021-10-21T05:47:08.644'),
       ('1137e39e-cdc6-4160-849f-bfa5506e7ba4', 'test4@abv.bg', '2021-10-21T05:47:08.644'),
       ('318ee786-4f1c-430a-8ac4-17f0393a38f1', 'test5@abv.bg', '2021-10-21T05:47:08.644');

insert ignore into surveys (data_id, answer_2, answer_3)
values ('2947c292-fb1f-4157-817c-0f533c14a278', '0','test1'),
       ('8fc49611-18c8-4e9a-b666-bc9015a0e71b', '1','test2'),
       ('b5c29689-f5a1-44c5-bad2-09afdd9a51ef', '2','test3'),
       ('1137e39e-cdc6-4160-849f-bfa5506e7ba4', '3','test4'),
       ('318ee786-4f1c-430a-8ac4-17f0393a38f1', '4','test5');

insert ignore into question_1_answers(id, value, survey_id)
values ('a8f56739-f5a1-44c5-bad2-09fwpt9a51rt', '0', '2947c292-fb1f-4157-817c-0f533c14a278'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a52rt', '2', '2947c292-fb1f-4157-817c-0f533c14a278'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a53rt', '1', '8fc49611-18c8-4e9a-b666-bc9015a0e71b'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a54rt', '3', '8fc49611-18c8-4e9a-b666-bc9015a0e71b'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a55rt', '2', 'b5c29689-f5a1-44c5-bad2-09afdd9a51ef'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a56rt', '4', '1137e39e-cdc6-4160-849f-bfa5506e7ba4'),
       ('a8f56739-f5a1-44c5-bad2-09fwpt9a57rt', '0', '318ee786-4f1c-430a-8ac4-17f0393a38f1');

insert ignore into text_input_1(value,survey_id)
values ('TEST_INPUT_1','1137e39e-cdc6-4160-849f-bfa5506e7ba4');

insert ignore into text_input_2(value, survey_id)
values ('TEST_INPUT_2','318ee786-4f1c-430a-8ac4-17f0393a38f1');