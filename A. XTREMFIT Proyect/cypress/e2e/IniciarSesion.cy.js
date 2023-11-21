describe('Iniciar Sesion', () => {
  it('passes', () => {
    cy.visit('http://localhost:9091/')
  
    //Hacer clic en Iniciar Sesion
    cy.get('#login-linkIC').click();

    //Acciones de Iniciar Sesion
    //*User
    cy.get('#userLogin').focus();
    cy.get('#userLogin').type('junior');
    cy.get('#userLogin').blur();
    //*Pass
    cy.get('#passwordLogin').focus();
    cy.get('#passwordLogin').type('junior ');
    cy.get('#passwordLogin').blur();
    //*Boton Iniciar Sesion
    cy.get('#InicioLogin').click();
    
    //*Verificar sin ingreso.
    cy.url().then((url) => {
      if (url.includes('/inicio')) {
        // La sesión se inició correctamente
        cy.log('¡Inicio de sesión exitoso!');
      } else {
        // La sesión no se inició correctamente, ir a la página de registro
        cy.log('Inicio de sesión fallido. Redirigiendo a la página de registro...');
        cy.get('#RegistrarLogin').click();
        cy.wait(1000);
        cy.get('#nom').type('alex');
        cy.wait(1000);
        cy.get('#ape').focus();
        cy.get('#ape').type('julca');
        cy.get('#ape').blur();
        cy.wait(1000);
        cy.get('#dni').type('12345678');
        cy.wait(1000);
        cy.get('#cel').type('123456789');
        cy.wait(1000);
        cy.get('#dir').type('Av. Casa');
        cy.wait(1000);
        cy.get('#user').type('alexj');
        cy.wait(1000);
        cy.get('#pass').type('alexj');
        cy.wait(1000);
        cy.get('#RegistrarLoginModal').click();
        cy.wait(1000);
        // Buscar un elemento que contenga el texto especificado
        cy.contains('Confirmar').click();
        cy.wait(1000);
        cy.contains('OK').click();
        cy.wait(1000);
        //*User
        cy.get('#userLogin').type('alexj');
        //*Pass
        cy.wait(1000);
        cy.get('#passwordLogin').type('alexj');
        cy.wait(1000);
        //*Boton Iniciar Sesion
        cy.get('#InicioLogin').click();

      }
    });
    
  })  
})