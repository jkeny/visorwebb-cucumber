pipeline{
	agent any
	
	tools{
		maven M3
		
	}

	parameters{
		choice(name: 'BROWSER', choices: ['chrome', 'edge'], description: 'Selecciona el navegador para la ejecución de las pruebas')
		
	}
	stages{
		stage('Limpiar repositorio y descargar fuentes'){
			
            steps {
                cleanWs()
                checkout scm
            }
			
		}
		
		stage('ejecutar pruebas automatizadas'){
			steps{
				echo "Iniciando la ejecución en el navegador: ${params.BROWSER}"
				bat "mvn clean verify -Denvironment=${params.BROWSER}"
			}
		}
	}
    post {
        always {
            // Forzamos a Jenkins a mantener o reabrir el espacio de trabajo local para publicar el HTML
            node {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Reporte Serenity BDD'
                ])
            }
        }
    }
}