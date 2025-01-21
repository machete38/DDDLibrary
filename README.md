Приложение-библиотека, написанная согласно концепции DDD (Domain Driven Design)
Архитектура:
Сущности (Entities) - Book (книга), User (пользователь), Loan (выдача книги)
Значимые объекты (Value objects) - ISBN (Международный стандартный книжный номер), BookStatus (Перечисление - статус книги: доступна, выдана)
Агрегаты (Aggregates) - BookAggregate (включает Book и BookStatus), LoanAggregate (включает Loan, User и Book)
