# PimVIII-Android

Aplicativo Android para consumir da API do projeto PimVIII-API.

## 📱 Sobre o Projeto

Este é um aplicativo Android desenvolvido em Java que se integra com a API do projeto PimVIII, fornecendo uma interface móvel para interação com os serviços backend.

## 🚀 Tecnologias Utilizadas

- **Java** - Linguagem principal de desenvolvimento
- **Android SDK** - Framework de desenvolvimento Android
- **Gradle** - Sistema de build e gerenciamento de dependências (Kotlin DSL)

## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- [Android Studio](https://developer.android.com/studio) (versão mais recente recomendada)
- JDK 11 ou superior
- Android SDK
- Emulador Android ou dispositivo físico para testes

## 🔧 Instalação

1. Clone o repositório:
```bash
git clone https://github.com/Vini-Paixao/PimVIII-Android.git
```

2. Abra o projeto no Android Studio:
   - Abra o Android Studio
   - Selecione "Open an existing project"
   - Navegue até a pasta do projeto clonado

3. Aguarde o Gradle sincronizar as dependências automaticamente

4. Configure a conexão com a API:
   - Certifique-se de que o projeto [PimVIII-API](https://github.com/Vini-Paixao/PimVIII-API) esteja rodando
   - Atualize as configurações de endpoint da API no projeto (se necessário)

## ▶️ Executando o Projeto

1. No Android Studio, selecione um dispositivo (emulador ou físico)
2. Clique no botão "Run" (▶️) ou pressione `Shift + F10`
3. Aguarde a compilação e instalação do aplicativo

Ou via linha de comando:

```bash
# Linux/Mac
./gradlew installDebug

# Windows
gradlew.bat installDebug
```

## 📁 Estrutura do Projeto

```
PimVIII-Android/
├── app/                    # Módulo principal do aplicativo
│   ├── src/               # Código fonte
│   │   ├── main/         # Código principal
│   │   └── test/         # Testes unitários
│   └── build.gradle.kts  # Configurações do módulo
├── gradle/                # Wrapper do Gradle
├── build.gradle.kts      # Configurações do projeto
└── settings.gradle.kts   # Configurações do Gradle
```

## 🔗 Projeto Relacionado

Este aplicativo consome a API do projeto:
- [PimVIII-API](https://github.com/Vini-Paixao/PimVIII-API)

## 👨‍💻 Autor

**Vini Paixão**
- GitHub: [@Vini-Paixao](https://github.com/Vini-Paixao)

## 📝 Licença

Este projeto não possui uma licença especificada.

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!
```
