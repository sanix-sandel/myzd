# myzd

To launch:
    -  sudo docker-compose up --build
    or .
        - chmod +x launch.sh
        - ./launch.sh
 Стек:
 Java, Maven, Spring boot, PostgresQL, Node.js, Vue.js, Docker.
 
- base route locahost:8000
- api route:
    - Чтобы получить все документы /api/getAll
    - чтобы получить документы по страницам /api/{номер_страницы}/{количество_документов}
    - Получить один элемент по именни /api/getuser/{имя}
    - Добавление документов api/generate/{количество_документов} 
    - Чтобы удалить один элемент /api/deleteone/{имя}
    - Удалить все элементы /api/delete/all
    - Удалить пакетно /api/delete/{количество_элементов}
        
    
-На frontend чтобы генирировать данных выбираите сначало Generate +5, также что бы удалить delete 5
Если вы хотите удалить один элемент прото нажмите delete (красная на правой шаге элемента)
