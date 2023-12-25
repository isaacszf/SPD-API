CREATE TABLE disease (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL UNIQUE,
    img_url TEXT,
    etiological_agent VARCHAR(200) NOT NULL,
    description TEXT NOT NULL,
    methods_of_contagion TEXT[] NOT NULL,
    symptoms TEXT[] NOT NULL,
    treatment TEXT NOT NULL,
    common_brazilian_states TEXT[] NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ
);
