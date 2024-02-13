create table message (
    id text     not null    constraint messages_pk primary key,
    created_at timestamp    with time zone  not null,
    updated_at timestamp    with time zone  not null,
    message text    not null
);

comment on table message is 'Table for messages';