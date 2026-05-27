ALTER TABLE contacts."user"
    ADD COLUMN IF NOT EXISTS user_telegram varchar(255),
    ADD COLUMN IF NOT EXISTS user_vk varchar(255);

UPDATE contacts."user"
SET user_telegram = 'https://t.me/andrschkit',
    user_vk       = 'https://vk.com/andrryuk'
WHERE user_telegram IS NULL
   OR user_vk IS NULL;
