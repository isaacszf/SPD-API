INSERT INTO disease (
    name,
    img_url,
    etiological_agent,
    description,
    methods_of_contagion,
    symptoms,
    treatment,
    common_brazilian_states,
    created_at,
    updated_at
) VALUES (
      'Febre Amarela',
      'https://i.imgur.com/WF1Mhrm.jpg',
      'Vírus Amarílico, gênero Flavivírus e família Flaviridae',
      'A febre amarela é uma doença infecciosa febril aguda, causada por um vírus transmitido por mosquitos vetores, e possui dois ciclos de transmissão: silvestre (quando há transmissão em área rural ou de floresta) e urbano. O vírus é transmitido pela picada dos mosquitos transmissores infectados e não há transmissão direta de pessoa a pessoa. A febre amarela tem importância epidemiológica por sua gravidade clínica e potencial de disseminação em áreas urbanas infestadas pelo mosquito Aedes aegypti.',
      '{"TRANSMISSAO_POR_VETORES"}',
      '{"Febre", "Dor de Cabeça", "Náuseas", "Vômitos"}',
      'Não existe medicamento para combater o vírus da febre amarela. O tratamento é apenas sintomático e requer cuidados na assistência ao paciente que, sob hospitalização, deve permanecer em repouso com reposição de líquidos e das perdas sangüíneas, quando indicado.',
      '{"SAO_PAULO", "PIAUI", "BAHIA", "MINAS_GERAIS", "PARANA", "SANTA_CATARINA", "RIO_GRANDE_DO_SUL"}',
       CURRENT_TIMESTAMP,
       null
    );

INSERT INTO disease (
    name,
    img_url,
    etiological_agent,
    description,
    methods_of_contagion,
    symptoms,
    treatment,
    common_brazilian_states,
    created_at,
    updated_at
) VALUES (
    'Febre Tifoide',
    'https://i.imgur.com/JhFDdFW.png',
    'Salmonella typhi',
    'A febre tifoide é uma doença infecciosa causada pela bactéria Salmonella typhi. É transmitida principalmente pela ingestão de água ou alimentos contaminados por fezes ou urina de pessoas infectadas. A doença é caracterizada por febre alta, dores abdominais, mal-estar, falta de apetite e pode ser grave se não tratada adequadamente.',
    '{"TRANSMISSAO_POR_ALIMENTOS_INFECTADOS"}',
    '{"Febre Alta", "Dores Abdominais", "Mal-estar", "Falta de Apetite"}',
    'O tratamento para a febre tifoide geralmente envolve antibióticos prescritos por um médico. O tratamento sintomático inclui repouso, ingestão de líquidos e uma dieta suave.',
    '{"BAHIA", "AMAZONAS"}',
    CURRENT_TIMESTAMP,
    null
);

INSERT INTO disease (
    name,
    img_url,
    etiological_agent,
    description,
    methods_of_contagion,
    symptoms,
    treatment,
    common_brazilian_states,
    created_at,
    updated_at
) VALUES (
    'COVID-19',
    'https://i.imgur.com/jQVL1fM.png',
    'SARS-CoV-2',
    'A COVID-19 é uma doença infecciosa causada pelo coronavírus SARS-CoV-2, identificado pela primeira vez em dezembro de 2019 na cidade de Wuhan, na China. A doença tem um amplo espectro de sintomas, que podem variar de leves a graves, incluindo febre, tosse, falta de ar, fadiga, dores musculares, perda de paladar ou olfato e complicações respiratórias agudas, como pneumonia.',
    '{"TRANSMISSAO_DE_GOTAS", "CONTATO_DIRETO"}',
    '{"Febre", "Tosse", "Falta de Ar", "Fadiga", "Perda de paladar ou olfato"}',
    'O tratamento para a COVID-19 é principalmente sintomático, focado no alívio dos sintomas, descanso, hidratação e monitoramento médico. Em casos graves, pode ser necessário suporte respiratório avançado. Além disso, foram desenvolvidas vacinas para prevenção da doença.',
    '{"SAO_PAULO", "RIO_DE_JANEIRO", "CEARA", "AMAZONAS", "PERNAMBUCO", "PARA"}',
    CURRENT_TIMESTAMP,
    null
);