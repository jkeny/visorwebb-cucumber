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
            // El bloque script le da el contexto necesario al plugin sin requerir parámetros extras
            script {
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