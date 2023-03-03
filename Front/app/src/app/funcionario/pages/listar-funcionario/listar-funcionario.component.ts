import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Funcionario } from '../../models/funcionario';
import { FuncionarioHttpService } from '../../services/funcionario-http.service';
import { DeleteDialogComponent } from '../../components/delete-dialog/delete-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-listar-funcionario',
  templateUrl: './listar-funcionario.component.html',
  styleUrls: ['./listar-funcionario.component.css']
})
export class ListarFuncionarioComponent implements OnInit {

  funcionarios: Funcionario[] = []
  /*= [
    {
      id: 1,
      nome:'Polly',
      email: 'polly@gmail.com',
      foto:'fdffdfdjk'
    },
    {
      id: 2,
      nome:'Edu',
      email: 'dudu@gmail.com',
      foto:'fdffdfdjk'
    },
 {
      id: 3,
      nome:'Thy',
      email: 'thy@gmail.com',
      foto:'fdffdfdjk'
    }
  ]*/


  columns: string[] = ['idFuncionario', 'nome', 'email', 'actions']

  constructor(
    private funHttpService: FuncionarioHttpService,
    private dialog: MatDialog,
    private snackbar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.recoverFuncionarios()
  }

  confirmationDelete(id: number) {
    const dialogRef = this.dialog.open(DeleteDialogComponent)
    
    dialogRef.afterClosed().subscribe(
      canDelete => {
        if (canDelete) {
          this.funHttpService.deleteFuncionario(id).subscribe(
            () => {
              this.snackbar.open('Funcionário deletado!', 'Ok', {
                duration: 3000,
                horizontalPosition: 'left',
                verticalPosition: 'top'
              })
              this.recoverFuncionarios()
             
            }
          )

        }
        
      }
    )
  }
  recoverFuncionarios() {
    this.funHttpService.getFuncionarios().subscribe(
      (funcionarios) => {
        this.funcionarios = funcionarios
      }
    )
  }
}